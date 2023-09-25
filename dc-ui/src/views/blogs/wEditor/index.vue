<template>
	<div>
		<BasicEditor :editorData="editorData" />
		<dig></dig>
	</div>
</template>

<script setup>
import BasicEditor from '@/components/Editor/BasicEditor.vue';
import Dig from '@/views/blogs/wEditor/C/dig.vue';

const editorData = {
    isInit:true,
    isOnlyRead:true,
    valueHtml: '<p>初始内容</p>',
    hasTitle:true,
    title:"初始化标题"
};
// const blogMsg = reactive({
// 	content: wEditorRef.value.valueHtml,
// });

const getChildValueHtml = () => {
	// console.log('父页面获取到的值', wEditorRef.value.valueHtml);
};

const setChildValueHtml = () => {
	wEditorRef.value.valueHtml = '<p>初始内容</p>';
};
</script>

<style scoped>

</style>
