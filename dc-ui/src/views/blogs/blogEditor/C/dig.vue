<script setup>

import { ref } from 'vue';
import { Plus } from '@element-plus/icons-vue';
import { updateArticle } from '../../../../api/system/article';

const { proxy } = getCurrentInstance();

const props = defineProps({ digData: Object });
const digData = ref(props.digData);
const dialogTableVisible = ref(false);
// 标签输入状态
const addVisible = ref(false);
// 新标签
const newTagValue = ref(null);
console.log(digData.value.toString(), 'digData');
const handleShow = () => {
	dialogTableVisible.value = true;
};

function tagTrans(tag) {
	console.log('标签被点击：', tag);
}

function addConfirm() {
	console.log('添加新标签事件');
	console.log(newTagValue.value, '新添加的标签');
	digData.value.tags.push({ 'code': newTagValue.value, flag: true, label: newTagValue.value });
	newTagValue.value = null;
	addVisible.value = false;
}

function showInput() {
	console.log('显示添加标签的输入框');
	addVisible.value = true;
}

function handleSubmit() {
	console.log(digData.value, '确认按钮被点击，获取到的值');
	digData.value.editorData;
	const articleObj = { ...digData.value, ...digData.value.editorData };
	delete articleObj.editorData;
	console.log(articleObj, '最终的文章对象');
	
	updateArticle(articleObj).then(response => {
		if( response.code === 200 ) {
			proxy.$modal.msgSuccess('文章修改成功！');
		}
	});
}

defineExpose({ handleShow });
</script>

<template>
	<el-dialog v-model='dialogTableVisible' center title='文章信息'>
		<el-form label-width='80px'>
			<el-form-item label='阅读类型'>
				<el-radio-group v-model='digData.readType'>
					<el-radio label='0'>无需验证</el-radio>
					<el-radio label='1'>密码验证</el-radio>
					<el-radio label='2'>仅自己</el-radio>
				</el-radio-group>
			</el-form-item>
			<el-form-item label='允许评论'>
				<el-switch
						v-model='digData.comment'
						active-text='允许'
						inactive-text='不允许'
				/>
			</el-form-item>
			
			<el-form-item label='封面图片'>
				<image-upload
						ref='upi'
						v-model='digData.coverImage'
						:fileSize='20'
						:fileType="['png', 'jpg', 'jpeg']"
						:isShowTip='true'
						:limit='1'
				/>
			</el-form-item>
			<el-form-item label='发布状态'>
				<el-radio-group v-model='digData.status'>
					<el-radio :label='0'>草稿</el-radio>
					<el-radio :label='1'>已发布</el-radio>
				</el-radio-group>
			</el-form-item>
			<el-form-item label='关键词'>
				<el-input v-model='digData.keywords' placeholder='请输入关键词' />
			</el-form-item>
			
			<el-form-item label='是否推荐'>
				<el-switch
						v-model='digData.recommended'
						active-text='允许'
						inactive-text='不允许'
				/>
			</el-form-item>
			
			<el-form-item label='是否置顶'>
				<el-switch
						v-model='digData.top'
						active-text='允许'
						inactive-text='不允许'
				/>
			</el-form-item>
			<el-form-item label='是否原创'>
				<el-switch
						v-model='digData.original'
						active-text='是'
						inactive-text='否'
				/>
			</el-form-item>
			<el-form-item label='阅读密码'>
				<el-input v-model='digData.password' placeholder='请输入关键词' />
			</el-form-item>
			
			<el-form-item form.tags label='文章标签'>
				<el-tag
						v-for='tag in digData.tags'
						:key='tag.code'
						:type="tag.flag ? 'success':'info'"
						class='mx-1'
						effect='dark'
						style='cursor: pointer; margin-left: 10px;'
						@click='tagTrans(tag)'
				>
					{{tag.label}}
				</el-tag>
				<el-input
						v-if='addVisible'
						v-model='newTagValue'
						clearable
						size='small'
						style='margin-left: 10px;width: 80px;'
						@blur='addConfirm'
						@keyup.enter.native='$event.target.blur()'
				/>
				<el-button v-else :icon='Plus' class='button-new-tag' size='small' style='width: 80px;' @click='showInput'>
				</el-button>
			</el-form-item>
			<el-form-item>
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
