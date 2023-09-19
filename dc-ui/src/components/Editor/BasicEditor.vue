<template>
  <div>
    <div style="border: 1px solid #ccc; margin-top: 10px">
      <Toolbar
          :editor="editorRef"
          style="border-bottom: 1px solid #ccc"
      />
      <Editor
          :defaultConfig="editorConfig"
          v-model="valueHtml"
          style="height: 400px; overflow-y: hidden"
          @onCreated="handleCreated"
      />
    </div>
    <div style="margin-top: 10px">
      <textarea
          v-model="valueHtml"
          readonly
          style="width: 100%; height: 200px; outline: none"
      ></textarea>
    </div>

  </div>
</template>

<script setup>
import '@wangeditor/editor/dist/css/style.css';
import { ref, shallowRef, defineExpose } from 'vue';
import { Editor, Toolbar } from '@wangeditor/editor-for-vue';
const editorRef = shallowRef();
const valueHtml = ref(null);
const editorConfig = { placeholder: '请输入内容...' };

const handleCreated = (editor) => {
  console.log('子组件内部打印：子组件被创建');
  editorRef.value = editor;
};


defineExpose({ valueHtml });
</script>
