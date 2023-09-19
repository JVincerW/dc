<template>
  <div class="editor-container">
    <Toolbar class="editorToolBar"
             :editor="editorRef"
    />
    <Editor
        :defaultConfig="editorConfig"
        v-model="valueHtml"
        class="editorBody"
        @onCreated="handleCreated"
    />
  </div>
</template>

<script setup>
import '@wangeditor/editor/dist/css/style.css';
import {ref, shallowRef, defineExpose} from 'vue';
import {Editor, Toolbar} from '@wangeditor/editor-for-vue';

const editorRef = shallowRef();
const valueHtml = ref(null);
const editorConfig = {placeholder: '请输入内容...'};

const handleCreated = (editor) => {
  console.log('子组件内部打印：子组件被创建');
  editorRef.value = editor;
};
defineExpose({valueHtml});
</script>
<style scoped>

.editorBody {
  border: 1px solid #00ff00;
  height: 100vh;;
}
.editor-container{
  height: 100vh;;
}
.editorToolBar {
  border: 1px solid #00f;
}
</style>
