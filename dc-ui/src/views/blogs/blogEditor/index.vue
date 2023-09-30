<template>
	<div>
		<el-button circle class='push' icon='Promotion' type='success' @click='digShow' />
		<div>
			<basic-editor v-if='showBasicEditor' :editorData='editorData' />
			<!--<dig ref='dig' digData='digData'></dig>-->
		</div>
	</div>
</template>

<script setup>
import BasicEditor from '../../../components/Editor/BasicEditor.vue';
import { getArticle } from '../../../api/system/article';

const proxy = getCurrentInstance().proxy;
let editorData;
let digData;
let showBasicEditor = false;
// const dig = ref();
onMounted(() => {
	const createType = proxy.$route.query.createType || 'init';
	console.log('编辑器加载类型:', createType || 'init');
	editorData = { createType: createType, enableEditor: true, hasTitile: true, content: '' };
	digData = { createType: createType, enableEditor: true };
	
	if( createType && createType === 'Mod' && proxy.$route.query.id ) {
		console.log('有文章可以做');
		getArticle(proxy.$route.query.id).then(response => {
			console.log(proxy.$route.query.id, '文章id');
			let { title, content, coverImage, editorType, readType, status, id, tags, top, recommended, original, keywords, comment, password } = response.data;
			editorData = { createType: createType, id, title, content, editorType, enableEditor: true, hasTitile: true };
			console.log(editorData);
			showBasicEditor = true;
			// digData = { createType: createType, id, readType, status, coverImage, top, tags, recommended, original, keywords, comment, password };
		});
		
		// const { title, content, coverImage, editorType, readType, status, id, tags, top, recommended, original, keywords, comment, password } = articleData;
		//
		// editorData = { createType: createType, id, title, content, editorType, enableEditor: true, hasTtile: true };
		//
		// digData = { createType: createType, id, readType, status, coverImage, top, tags, recommended, original, keywords, comment, password };
		// showBasicEditor.value = true;
		// console.log(articleData, '编辑页面被初始化的数据');
	}
	
});

function digShow() {
	console.log(555);
	
}

// const digShow = () => {
// 	digData.value.editorData = editorData.value;
// 	console.log(editorData.value, 'digData.value.editorData');
// 	dig.value.handleShow();
// };
</script>

<style scoped>
.push {
	position: absolute;
	bottom: 39px;
	right: 80px;
	z-index: 99;
}
</style>
