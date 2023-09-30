<template>
	<div>
		<el-button circle class='push' icon='Promotion' type='success' @click='digShow' />
		<div>
			<basic-editor v-if='showBasicEditor' ref='editorIndex' :editorData='editorData' />
			<artic-dig v-if='digData' ref='articleDig' :digData='digData'></artic-dig>
		</div>
	</div>
</template>

<script setup>
import BasicEditor from '../../../components/Editor/BasicEditor.vue';
import ArticDig from '../../../components/Editor/ArticDig.vue';
import { getArticle } from '../../../api/system/article';

const digData = ref({ createType: 'init', enableEditor: true, hasTitile: true, content: '', title: '' });
const proxy = getCurrentInstance().proxy;
const editorData = ref({ createType: 'init', enableEditor: true, hasTitile: true, content: '' });
const showBasicEditor = ref();
const editorIndex = ref();
const articleDig = ref();
onBeforeMount(() => {
	const createType = proxy.$route.query.createType || 'init';
	console.log('编辑器加载类型:', createType);
	console.log('要编辑的文章id:', proxy.$route.query.id);
	if( createType === 'Mod' && proxy.$route.query.id ) {
		getArticle(proxy.$route.query.id).then(response => {
			const { title, content, coverImage, editorType, readType, status, id, tags, top, recommended, original, keywords, comment, password } = response.data;
			editorData.value = { createType: createType, id, title, content, editorType, enableEditor: true, hasTitile: true };
			digData.value = { createType: createType, title, id, readType, status, coverImage, top, tags, recommended, original, keywords, comment, password };
		});
	} else {
		editorData.value = { createType: createType, enableEditor: true, hasTitile: true, title: '', content: '' };
		digData.value = { createType: createType, title: '' };
	}
	editorIndex.showBasicEditor = true;
	showBasicEditor.value = true;
});

function digShow() {
	console.log(555);
	
	articleDig.value.handleShow();
}

</script>

<style scoped>
.push {
	position: absolute;
	bottom: 39px;
	right: 80px;
	z-index: 99;
}
</style>
