<template>
	<div>
		<el-button circle class='push' icon='Promotion' type='success' @click='getChildValueHtml' />
		<div>
			<!--<BasicEditor ref='wEditorRef' :editorData='editorData' />-->
			<async-basic-editor v-if='showBasicEditor' :editorData='editorData' />
			<async-article-dig ref='dig' :digData='digData'></async-article-dig>
		</div>
	</div>
</template>

<script setup>
import { useArticleStore } from '../../../store/modules/articleStore';

const AsyncBasicEditor = defineAsyncComponent(() => import('@/components/Editor/BasicEditor.vue'));
const AsyncArticleDig = defineAsyncComponent(() => import('@/views/blogs/blogEditor/C/dig.vue'));
const { proxy } = getCurrentInstance();

// 编辑器需要的数据
const editorData = ref({});
const digData = ref({});
const showBasicEditor = ref(false);
onMounted(() => {
	const createType = proxy.$route.query.createType;
	console.log('编辑器加载类型:', createType);
	console.log('编辑页面加载');
	const articleStore = useArticleStore();
	const articleData = articleStore.articleData;
	
	if( articleData ) {
		const { title, content, coverImage, editorType, readType, status, id, tags, top, recommended, original, keywords, comment, password } = articleData;
		editorData.value = { createType: createType, id, title, content, editorType, enableEditor: true, hasTtile: title && title.length > 1 };
		digData.value = { createType: createType, id, readType, status, coverImage, top, tags, recommended, original, keywords, comment, password };
		showBasicEditor.value = true;
		console.log(articleData, '编辑页面被初始化的数据');
	} else {
		editorData.value = { createType: 'init', enableEditor: true };
		digData.value = { createType: 'init', enableEditor: true };
		showBasicEditor.value = true;
		console.log(articleData, '编辑页面被初始化的数据');
	}
});

const wEditorRef = ref();
const dig = ref();

const getChildValueHtml = () => {
	console.log('父页面获取到的值', wEditorRef.value);
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
