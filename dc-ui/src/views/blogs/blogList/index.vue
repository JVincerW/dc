<template>
	<div class='app-container'>
		<el-form ref='queryRef' :inline='true' :model='queryParams' label-width='68px'>
			<el-form-item label='标题' prop='title'>
				<el-input
						v-model='queryParams.title'
						clearable
						placeholder='请输入标题'
						@keyup.enter='handleQuery'
				/>
			</el-form-item>
			<el-form-item label='用户ID' prop='userId'>
				<el-input
						v-model='queryParams.userId'
						clearable
						placeholder='请输入用户ID'
						@keyup.enter='handleQuery'
				/>
			</el-form-item>
			<el-form-item>
				<el-button icon='Search' type='primary' @click='handleQuery'>搜索</el-button>
				<el-button icon='Refresh' @click='resetQuery'>重置</el-button>
			</el-form-item>
		</el-form>
		
		<el-row :gutter='10' class='mb8'>
			<el-col :span='1.5'>
				<el-button
						icon='Plus'
						plain
						type='primary'
						vPermi="['system:article:add']"
						@click='handleAdd'
				>新增
				</el-button>
			</el-col>
			<el-col :span='1.5'>
				<el-button
						:disabled='single'
						icon='Edit'
						plain
						type='success'
						vPermi="['system:article:edit']"
						@click='handleUpdate'
				>修改
				</el-button>
			</el-col>
			<el-col :span='1.5'>
				<el-button
						:disabled='multiple'
						icon='Delete'
						plain
						type='danger'
						vPermi="['system:article:remove']"
						@click='handleDelete'
				>删除
				</el-button>
			</el-col>
			<el-col :span='1.5'>
				<el-button
						icon='Download'
						plain
						type='warning'
						vPermi="['system:article:export']"
						@click='handleExport'
				>导出
				</el-button>
			</el-col>
			<right-toolbar @queryTable='getList'></right-toolbar>
		</el-row>
		
		<el-table v-loading='loading' :data='articleList' @selection-change='handleSelectionChange'>
			<el-table-column align='center' type='selection' width='55' />
			<el-table-column align='center' label='文档id' prop='id' />
			<el-table-column align='center' label='标题' prop='title' />
			<el-table-column align='center' label='用户ID' prop='userId' />
			<el-table-column align='center' label='点赞数' prop='pollCount' />
			<el-table-column align='center' label='封面图' prop='coverImage' width='100'>
				<template #default='scope'>
					<image-preview :height='50' :src='scope.row.coverImage' :width='50' />
				</template>
			</el-table-column>
			<el-table-column align='center' label='评论数' prop='commentCount' />
			<el-table-column align='center' label='阅读类型' prop='readType' />
			<el-table-column align='center' label='编辑类型' prop='editorType' />
			<el-table-column align='center' label='是否置顶' prop='top' />
			<el-table-column align='center' label='状态' prop='status' />
			<el-table-column align='center' label='是否推荐' prop='recommended' />
			<el-table-column align='center' label='是否开启评论' prop='comment' />
			<el-table-column align='center' label='更新时间' prop='updateAt' width='180' />
			<el-table-column align='center' class-name='small-padding fixed-width' label='操作'>
				<template #default='scope'>
					<el-button icon='Edit' link type='primary' vPermi="['system:article:edit']" @click='handleEditor(scope.row)'>编辑</el-button>
					<el-button icon='Operation' link type='primary' vPermi="['system:article:edit']" @click='handleUpdate(scope.row)'>修改</el-button>
					<el-button icon='Delete' link type='primary' vPermi="['system:article:remove']" @click='handleDelete(scope.row)'>删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		
		<pagination
				v-show='total > 0'
				v-model:limit='queryParams.pageSize'
				v-model:page='queryParams.pageNum'
				:total='total'
				@pagination='getList'
		/>
		<artic-dig ref='articleDig' :digData='digData'></artic-dig>
	</div>
</template>

<script setup>
import { reactive, ref } from 'vue';
import { delArticle, listArticle } from '@/api/system/article';
import { useArticleStore } from '../../../store/modules/articleStore';
import ArticDig from '../../../components/Editor/ArticDig.vue';
import { getArticle } from '../../../api/system/article';

const { proxy } = getCurrentInstance();
const articleList = ref([]);
const loading = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const articleDig = ref();
const digData = ref();
const curForm = ref({});
const data = reactive({
	queryParams: {
		pageNum: 1,
		pageSize: 10,
		title: null,
		userId: null,
		status: null,
	},
});

const { queryParams } = toRefs(data);

/** 查询博客文章列表 */
function getList() {
	loading.value = true;
	listArticle(queryParams.value)
	.then((response) => {
		articleList.value = response.rows;
		total.value = response.total;
		loading.value = false;
	})
	.catch((error) => {
		console.error('Error fetching article list:', error);
	});
}

// 取消按钮
function cancel() {
	reset();
}

// 表单重置
function reset() {
	curForm.value = {};
}

/** 搜索按钮操作 */
function handleQuery() {
	queryParams.value.pageNum = 1;
	getList();
}

/** 重置按钮操作 */
function resetQuery() {
	proxy.resetForm('queryRef');
	handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
	ids.value = selection.map((item) => item.id);
	single.value = selection.length !== 1;
	multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
	reset();
	proxy.$router.push({ path: 'blogEditor', query: { createType: 'init' } });
}

/** 修改按钮操作 */
function handleUpdate(row) {
	reset();
	const _id = row.id || ids.value;
	getArticle(_id)
	.then((response) => {
		digData.value = response.data;
		const { readType, comment, coverImage, status, keywords, recommended, top, original, password, tags, title } = response.data;
		digData.value = { id: _id, readType, comment, coverImage, status, keywords, recommended, top, original, password, tags, title, createType: 'Mod' };
		articleDig.value.handleShow();
	})
	.catch((error) => {
		proxy.$modal.msgSuccess('Error fetching article data:', error);
	});
}

/** 编辑按钮操作 */
function handleEditor(row) {
	reset();
	const _id = row.id || ids.value;
	const articleStore = useArticleStore();
	articleStore.setArticleData(_id); // 传入文章ID
	proxy.$router.push({ path: 'blogEditor', query: { createType: 'Mod', id: _id } });
}

/** 删除按钮操作 */
function handleDelete(row) {
	const _ids = row.id || ids.value;
	proxy.$modal
	.confirm('是否确认删除博客文章编号为"' + _ids + '"的数据项？')
	.then(function() {
		return delArticle(_ids);
	})
	.then(() => {
		getList();
		proxy.$modal.msgSuccess('删除成功');
	})
	.catch((error) => {
		console.error('Error deleting article:', error);
	});
}

/** 导出按钮操作 */
function handleExport() {
	proxy.download('system/article/export', {
		...queryParams.value,
	}, `article_${ new Date().getTime() }.xlsx`);
}

getList();
</script>
