<template>
    <div ref="cref" class="bg-red">
        <Toolbar :editor="editorRef" class="tb" />
        <div class="scroll-container">
            <div class="inputDeep" v-if="initEditor.hasTitle">
                <el-input v-model="initEditor.title" placeholder="请输入标题"></el-input>
            </div>
            <Editor v-model="initEditor.valueHtml" :defaultConfig="editorConfig" style="background-color: #fff" @onCreated="handleCreated" />
        </div>
    </div>
</template>

<script setup props="props">
import '@wangeditor/editor/dist/css/style.css';
import { ref, shallowRef, defineProps } from 'vue';
import { Editor, Toolbar } from '@wangeditor/editor-for-vue';

const editorRef = shallowRef();
const props = defineProps({editorData:Object});
const initEditor=props.editorData
const editorConfig = { placeholder: '请输入内容...', scroll: false,readOnly :initEditor.isOnlyRead};
console.log(props.editorData,"editorData")
// 使用 ref 引用元素
const cref = ref(null);

const handleCreated = (editor) => {
    console.log('子组件内部打印：子组件被创建');
    editorRef.value = editor;
    console.log(editor.getConfig());
};
</script>

<style scoped>
.bg-red {
	display: flex;
	flex-direction: column;
	padding: 10px;
	height: calc(100vh - 84px);
	background-color: #eee;
	box-sizing: border-box;
}

.tb {
	top: 0;
	width: 100%;
	border-bottom: 1px solid #ccc;
	box-sizing: border-box;
	z-index: 999;
}

.scroll-container {
	border-top: 1px solid #ccc;
	box-sizing: border-box;
	background-color: #fff;
	overflow-y: scroll;
	display: flex; /* 使用flex布局 */
	flex-direction: column; /* 垂直方向布局 */
	flex: 1;
}

/* 使用 :deep() 来覆盖 Element Plus 的默认样式 */
.inputDeep :deep(.el-input__inner) {
	border: 0;
	font-size: 2em;
	height: 2.5em;
	text-align: center;

}

/* 去掉输入框的边框，聚焦时也没有边框 */
.inputDeep :deep(.el-input__wrapper) {
	border-bottom: 1px solid #ccc;
	box-sizing: border-box;
	box-shadow: none;
	border-radius: unset;
}
</style>
