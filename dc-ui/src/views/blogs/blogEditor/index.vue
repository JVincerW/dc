<template>
	<div>
		<el-button circle class='push' icon='Promotion' type='success' @click='getChildValueHtml' />
		<div>
			<BasicEditor ref='wEditorRef' :editorData='editorData' />
			<dig ref='dig' :editorData='editorData'></dig>
		</div>
	</div>
</template>

<script setup>
import BasicEditor from '@/components/Editor/BasicEditor.vue';
import Dig from '@/views/blogs/blogEditor/C/dig.vue';
import store from '../../../store';

const { proxy } = getCurrentInstance();

onMounted(() => {
	const blogData = store.state.value.curBlog;
	console.log(blogData, 'blogData');
	console.log(blogData.coverImage, 'coverImage');
});
const wEditorRef = ref();
const dig = ref();
const editorData = {
	isInit: true,
	isOnlyRead: false,
	valueHtml: '<p>初始内容</p>',
	hasTitle: true,
	title: '初始化标题',
};

const getChildValueHtml = () => {
	console.log('父页面获取到的值', wEditorRef.value.initEditor);
	dig.value.handleShow();
};
</script>

<style scoped>
.push {
	position: absolute;
	bottom: 39px;
	right: 80px;
	z-index: 99;
}
</style>
