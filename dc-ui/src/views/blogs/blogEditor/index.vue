<template>
	<div>
		<el-button circle class='push' icon='Promotion' type='success' @click='digShow' />
		<div>
			<basic-editor v-if='showBasicEditor' ref='editorIndex' :editorData='articleForm' :editorSetting='editorSetting' />
			<artic-dig ref='articleDig' :digData='articleForm'></artic-dig>
		</div>
	</div>
</template>

<script setup>
import BasicEditor from '../../../components/Editor/BasicEditor.vue';
import ArticDig from '../../../components/Editor/ArticDig.vue';
import { getArticle } from '../../../api/system/article';

const proxy = getCurrentInstance().proxy;
const showBasicEditor = ref();
const editorIndex = ref();
const articleDig = ref();
const editorSetting = ref({
	enableEditor: true,
	hasTitile: true,
});

const articleForm = ref();
onBeforeMount(() => {
	reset();
	const createType = proxy.$route.query.createType || 'init';
	console.log('编辑器加载类型:', createType);
	console.log('要编辑的文章id:', proxy.$route.query.id);
	if( createType === 'Mod' && proxy.$route.query.id ) {
		getArticle(proxy.$route.query.id).then(response => {
			articleForm.value = response.data;
			articleForm.value.createType = 'Mod';
			console.log(1111111);
			console.log(articleForm, 'articleForm');
		});
	} else {
		console.log(6666666);
		
		reset();
		articleForm.createType = 'init';
	}
	editorIndex.showBasicEditor = true;
	showBasicEditor.value = true;
});

function reset() {
	articleForm.value = {
		title: '',
		content: '',
		coverImage: null,
		editorType: '0',
		readType: '0',
		status: '',
		tags: [],
		top: false,
		recommended: false,
		original: '0',
		keywords: null,
		comment: false,
		password: null,
	};
	
}

function digShow() {
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
