<script setup>
import { ref } from 'vue';
import { Plus } from '@element-plus/icons-vue';
import { uploadFileRequest } from '@/api/system/file';

const articTypes = [ '分类1', '分类2', '分类3', '分类4', '分类5' ];
const tags       = ref([
	{ id: 1, type: '', label: 'java', flag: false },
	{ id: 2, type: 'success', label: 'vue', flag: false },
	{ id: 3, type: 'info', label: '博客', flag: false },
	{ id: 4, type: 'danger', label: '生活', flag: false },
	{ id: 5, type: 'warning', label: '感悟', flag: false },
]);

const dialogTableVisible = true;
const uploadFile         = (msg) => {
	console.log(msg.file);
	uploadFileRequest(msg.file).then(response => {
		console.log(response);
	});
	// uploadFile
	// console.log('ddd');
	
};
const tag                = (clickedTag) => {
	clickedTag.flag = !clickedTag.flag;
	
	// 更新selectedTags
	selectedTags = tags.value.filter((tag) => tag.flag).map((tag) => tag.label);
};

const handleCancel = () => {
	console.log('ddd2');
};
const handleSubmit = () => {
	console.log('选择的阅读类型：', selectedReadType);
	console.log('选择的文章分类：', selectedCategory);
	console.log('选择的文章标签：', selectedTags);
	console.log('选择的封面图片：', selectedCoverImage);
};

let selectedReadType   = 0;
let selectedCategory   = articTypes[0];
let selectedTags       = tags.value.filter((tag) => tag.flag).map((tag) => tag.label);
let selectedCoverImage = '';
</script>

<template>
	<el-dialog v-model='dialogTableVisible' :visible.sync='false' center title='文章信息' width='30%'>
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
			<el-form-item form.tags label='文章标签'>
				<el-tag
						v-for='item in tags'
						:key='item.id'
						:type="item.flag ? 'info' : 'success'"
						effect='dark'
						style='cursor: pointer; margin-left: 10px'
						@click='tag(item)'
				>
					{{ item.label }}
				</el-tag>
			</el-form-item>
			<el-form-item label='封面图片'>
				<el-upload
						:http-request='uploadFile'
						:limit='1'
						:show-file-list='false'
						action='#'
						class='avatar-uploader'
				>
					<img v-if='false' alt='ggg' class='avatar' src='https://img-blog.csdnimg.cn/d658f31b81f84566be9de5b6db880b82.png' />
					<el-icon v-else class='avatar-uploader-icon'>
						<Plus />
					</el-icon>
				</el-upload>
			</el-form-item>
			<el-form-item>
				<el-button @click='handleCancel'>取消</el-button>
				<el-button type='primary' @click='handleSubmit'>确认</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
</template>

<style lang='scss' scoped>
.f_r {
	position: fixed;
	width: auto;
	bottom: 40px; /* 距离底部的距离，根据需要调整 */
	right: 60px; /* 距离右边的距离，根据需要调整 */
}

.inputDeep :deep(.el-input__inner) {
	border: 0;
	font-size: 2em;
	height: 40px;
	text-align: center;
	border-bottom: 1px solid #ccc;
	margin-bottom: 10px;
}

.disabled .el-upload--picture-card {
	display: none;
}
</style>

<style scoped>
.avatar-uploader .avatar {
	width: 178px;
	height: 178px;
	display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
	border: 1px dashed var(--el-border-color);
	border-radius: 6px;
	cursor: pointer;
	position: relative;
	overflow: hidden;
	transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
	border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
	font-size: 28px;
	color: #8c939d;
	width: 178px;
	height: 178px;
	text-align: center;
}
</style>
