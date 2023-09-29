<script setup>

import { addData, getDicts } from '@/api/system/dict/data';
import { Plus } from '@element-plus/icons-vue';
import { ref } from 'vue';

const props = defineProps({ dialogTableVisible: Boolean, editorData: Object });
const editorData = props.editorData;
const articTypes = [ '分类1', '分类2', '分类3', '分类4', '分类5' ];
const selectedStatus = ref();
const status = [ '发布', '草稿' ];
const selectedCoverImages = ref([]);
const tags = ref([]);
const dialogTableVisible = ref(false);
const { proxy } = getCurrentInstance();
const newTagValue = ref();
let selectedReadType = ref(0);
let selectedCategory = ref(articTypes[0]);
const addVisible = ref();
const handleShow = () => {
	dialogTableVisible.value = true;
	initTags();
};
const tagTrans = (clickedTag) => {
	// 检查已选中的标签数量
	const selectedCount = tags.value.filter(tag => tag.flag).length;
	
	if( selectedCount < 3 || clickedTag.flag ) {
		clickedTag.flag = !clickedTag.flag;
	} else {
		proxy.$modal.msgWarning('最多选择三个标签，请取消选中的标签后重新选择');
	}
};

// 计算属性
const selectedTagsLabel = computed(() => {
	return tags.value.filter((tag) => tag.flag).map((tag) => tag.dictLabel);
});
const initTags = () => {
	getDicts('artic_tags').then(resp => {
		const tags_tmp = resp.data;
		tags_tmp.map((tag) => tag.flag = false);
		tags.value = resp.data;
		console.log(tags.value);
	});
};

function showInput() {
	console.log('打印');
	addVisible.value = true;
}

function addConfirm() {
	addVisible.value = false;
	console.log('新增标签', newTagValue.value);
	if( newTagValue.value && newTagValue.value.length > 0 ) {
		addData({
			'dictLabel': newTagValue.value,
			'dictValue': newTagValue.value,
			'dictType': 'artic_tags',
			'dictSort': 0,
		})
		.then((res) => {
			console.log(res);
			// 添加成功后设置新标签的默认值为true
			const newTag = {
				dictLabel: newTagValue.value,
				dictValue: newTagValue.value,
				dictType: 'artic_tags',
				dictSort: 0,
				flag: true, // 默认值为true
				isCreate: true,
				
			};
			tags.value.push(newTag); // 将新标签添加到tags数组
			newTagValue.value = null; // 清空输入框
		})
		.catch((error) => {
			console.error(error);
			proxy.$modal.msgError(error);
		});
	}
}

const handleCancel = () => {
	dialogTableVisible.value = false;
};

const handleSubmit = () => {
	console.log('选择的阅读类型：', selectedReadType.value);
	console.log('选择的文章分类：', selectedCategory.value);
	console.log('选择的文章标签：', selectedTagsLabel.value);
	console.log('选择的封面图片：', selectedCoverImages.value);
	console.log('选择的发布状态：', selectedStatus.value);
	console.log(editorData, 'editorData');
};
defineExpose({ handleShow });
</script>

<template>
	<el-dialog v-model='dialogTableVisible' center title='文章信息' width='30%'>
		<el-form label-width='80px'>
			<el-form-item label='阅读类型'>
				<el-radio-group v-model='selectedReadType'>
					<el-radio :label='0'>无需验证</el-radio>
					<el-radio :label='1'>评论阅读</el-radio>
					<el-radio :label='2'>点赞阅读</el-radio>
					<el-radio :label='3'>扫码阅读</el-radio>
				</el-radio-group>
			</el-form-item>
			<el-form-item label='文章分类'>
				<el-select v-model='selectedCategory' placeholder='请选择分类'>
					<el-option v-for='item in articTypes' :key='item' :label='item' :value='item'></el-option>
				</el-select>
			</el-form-item>
			
			<el-form-item label='发布状态'>
				<el-select v-model='selectedStatus' placeholder='发布状态'>
					<el-option v-for='status_item in status' :key='status_item' :label='status_item' :value='status_item'></el-option>
				</el-select>
			</el-form-item>
			<el-form-item form.tags label='文章标签'>
				<el-tag
						v-for='tag in tags'
						:key='tag.code'
						:type="tag.flag ? 'success':'info'"
						class='mx-1'
						effect='dark'
						style='cursor: pointer; margin-left: 10px;margin-top: 10px'
						@click='tagTrans(tag)'
				>
					{{tag.dictLabel}}
				</el-tag>
				<el-input
						v-if='addVisible'
						v-model='newTagValue'
						clearable
						size='small'
						style='margin-left: 10px;width: 80px;margin-top: 10px'
						@blur='addConfirm'
						@keyup.enter.native='$event.target.blur()'
				
				/>
				<el-button v-else :icon='Plus' class='button-new-tag' size='small' style='width: 80px;margin-top: 10px' @click='showInput'>
				</el-button>
			</el-form-item>
			<el-form-item label='封面图片'>
				<image-upload
						ref='upi'
						v-model='selectedCoverImages'
						:fileSize='20'
						:fileType="['png', 'jpg', 'jpeg']"
						:isShowTip='true'
						:limit='1'
				/>
			</el-form-item>
			<el-form-item>
				<el-button @click='handleCancel'>取消</el-button>
				<el-button clearable maxlength='5' type='primary' @click='handleSubmit'>确认</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
</template>

<style lang='scss'>

.button-new-tag {
	margin-left: 10px;
	padding-top: 0;
	padding-bottom: 0;
}

</style>
