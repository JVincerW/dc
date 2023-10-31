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
import { getArticle } from '../../../api/system/blogs';

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
    "allowComment": true,
    "appreciation": true,
    "contentType": 0,
    "content": "",
    "createBy": "",
    "excerpt": "string",
    "imageUrl": "string",
    "remark": "string",
    "readType":0,
    "status": 0,
    "title": "",
    "userId": 0,
  }
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
