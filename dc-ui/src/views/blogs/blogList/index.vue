<template>
	<div class='app-container'>
		<el-form v-show='showSearch' ref='queryRef' :inline='true' :model='queryParams' label-width='68px'>
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
						v-hasPermi="['system:article:add']"
						icon='Plus'
						plain
						type='primary'
						@click='handleAdd'
				>新增
				</el-button>
			</el-col>
			<el-col :span='1.5'>
				<el-button
						v-hasPermi="['system:article:edit']"
						:disabled='single'
						icon='Edit'
						plain
						type='success'
						@click='handleUpdate'
				>修改
				</el-button>
			</el-col>
			<el-col :span='1.5'>
				<el-button
						v-hasPermi="['system:article:remove']"
						:disabled='multiple'
						icon='Delete'
						plain
						type='danger'
						@click='handleDelete'
				>删除
				</el-button>
			</el-col>
			<el-col :span='1.5'>
				<el-button
						v-hasPermi="['system:article:export']"
						icon='Download'
						plain
						type='warning'
						@click='handleExport'
				>导出
				</el-button>
			</el-col>
			<right-toolbar v-model:showSearch='showSearch' @queryTable='getList'></right-toolbar>
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
			<el-table-column align='center' label='更新时间' prop='updateAt' width='180'>
				<template #default='scope'>
					<span>{{parseTime(scope.row.updateAt, '{y}-{m}-{d}')}}</span>
				</template>
			</el-table-column>
			<el-table-column align='center' class-name='small-padding fixed-width' label='操作'>
				<template #default='scope'>
					<el-button v-hasPermi="['system:article:edit']" icon='Edit' link type='primary' @click='handleUpdate(scope.row)'>修改</el-button>
					<el-button v-hasPermi="['system:article:remove']" icon='Delete' link type='primary' @click='handleDelete(scope.row)'>删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		
		<pagination
				v-show='total>0'
				v-model:limit='queryParams.pageSize'
				v-model:page='queryParams.pageNum'
				:total='total'
				@pagination='getList'
		/>
		
		<!-- 添加或修改博客文章对话框 -->
		<el-dialog v-model='open' :title='title' append-to-body width='500px'>
			<el-form ref='articleRef' :model='form' :rules='rules' label-width='80px'>
				<el-form-item label='博客id' prop='uuid'>
					<el-input v-model='form.uuid' placeholder='请输入博客id' />
				</el-form-item>
				<el-form-item label='版本号' prop='version'>
					<el-input v-model='form.version' placeholder='请输入版本号' />
				</el-form-item>
				<el-form-item label='标题' prop='title'>
					<el-input v-model='form.title' placeholder='请输入标题' />
				</el-form-item>
				<el-form-item label='文章内容'>
					<editor v-model='form.content' :min-height='192' />
				</el-form-item>
				<el-form-item label='用户ID' prop='userId'>
					<el-input v-model='form.userId' placeholder='请输入用户ID' />
				</el-form-item>
				<el-form-item label='点赞数' prop='pollCount'>
					<el-input v-model='form.pollCount' placeholder='请输入点赞数' />
				</el-form-item>
				<el-form-item label='封面图' prop='coverImage'>
					<image-upload v-model='form.coverImage' />
				</el-form-item>
				<el-form-item label='评论数' prop='commentCount'>
					<el-input v-model='form.commentCount' placeholder='请输入评论数' />
				</el-form-item>
				<el-form-item label='二维码' prop='qrcodePath'>
					<el-input v-model='form.qrcodePath' placeholder='请输入二维码' />
				</el-form-item>
				<el-form-item label='文章简介' prop='description'>
					<el-input v-model='form.description' placeholder='请输入文章简介' />
				</el-form-item>
				<el-form-item label='关键字' prop='keywords'>
					<el-input v-model='form.keywords' placeholder='请输入关键字' />
				</el-form-item>
				<el-form-item label='文章私密访问时的密钥' prop='password'>
					<el-input v-model='form.password' placeholder='请输入文章私密访问时的密钥' />
				</el-form-item>
			</el-form>
			<template #footer>
				<div class='dialog-footer'>
					<el-button type='primary' @click='submitForm'>确 定</el-button>
					<el-button @click='cancel'>取 消</el-button>
				</div>
			</template>
		</el-dialog>
	</div>
</template>

<script name='Article' setup>
import { addArticle, delArticle, getArticle, listArticle, updateArticle } from '@/api/system/article';

const { proxy } = getCurrentInstance();

const articleList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref('');

const data = reactive({
	form: {},
	queryParams: {
		pageNum: 1,
		pageSize: 10,
		title: null,
		userId: null,
		status: null,
	},
	rules: {},
});

const { queryParams, form, rules } = toRefs(data);

/** 查询博客文章列表 */
function getList() {
	loading.value = true;
	listArticle(queryParams.value).then(response => {
		articleList.value = response.rows;
		total.value = response.total;
		loading.value = false;
	});
}

// 取消按钮
function cancel() {
	open.value = false;
	reset();
}

// 表单重置
function reset() {
	form.value = {
		id: null,
		uuid: null,
		version: null,
		title: null,
		content: null,
		userId: null,
		pollCount: null,
		coverImage: null,
		commentCount: null,
		readType: null,
		editorType: null,
		qrcodePath: null,
		top: null,
		status: null,
		recommended: null,
		original: null,
		description: null,
		keywords: null,
		comment: null,
		password: null,
		createAt: null,
		updateAt: null,
	};
	proxy.resetForm('articleRef');
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
	ids.value = selection.map(item => item.id);
	single.value = selection.length != 1;
	multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
	reset();
	open.value = true;
	title.value = '添加博客文章';
}

/** 修改按钮操作 */
function handleUpdate(row) {
	reset();
	const _id = row.id || ids.value;
	getArticle(_id).then(response => {
		form.value = response.data;
		open.value = true;
		title.value = '修改博客文章';
	});
}

/** 提交按钮 */
function submitForm() {
	proxy.$refs['articleRef'].validate(valid => {
		if( valid ) {
			if( form.value.id != null ) {
				updateArticle(form.value).then(response => {
					proxy.$modal.msgSuccess('修改成功');
					open.value = false;
					getList();
				});
			} else {
				addArticle(form.value).then(response => {
					proxy.$modal.msgSuccess('新增成功');
					open.value = false;
					getList();
				});
			}
		}
	});
}

/** 删除按钮操作 */
function handleDelete(row) {
	const _ids = row.id || ids.value;
	proxy.$modal.confirm('是否确认删除博客文章编号为"' + _ids + '"的数据项？').then(function() {
		return delArticle(_ids);
	}).then(() => {
		getList();
		proxy.$modal.msgSuccess('删除成功');
	}).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
	proxy.download('system/article/export', {
		...queryParams.value,
	}, `article_${ new Date().getTime() }.xlsx`);
}

getList();
</script>
