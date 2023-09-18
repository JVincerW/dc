<template>
  <div>
    <p>Vue3 wangEditor demo</p>
    <button @click="getChildValueHtml">获取子组件的 valueHtml</button>
    <button @click="setChildValueHtml">设置子组件的 valueHtml</button>
    <!-- 在子组件中通过 props 接收，不需要再使用 :initialValueHtml="initialValueHtml" -->
    <BasicEditor :initData="initData" ref="editorRef" />
  </div>
</template>

<script setup>
import BasicEditor from "@/components/Editor/BasicEditor.vue";
import { ref } from 'vue';

const editorRef = ref(null);

// 包装 initValueHtml 在对象中
const initData = { html: "<p>初始内容</p>" };

const getChildValueHtml = () => {
  // 获取子组件的 valueHtml
  console.log("父页面获取到的值", editorRef.value.valueHtml);
};

const setChildValueHtml = () => {
  // 设置子组件的 valueHtml
  editorRef.value.valueHtml = initData.html;
};
</script>
