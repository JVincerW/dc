<template>
  <div>
    <p>Vue3 wangEditor demo</p>
    <button @click="getChildValueHtml">获取子组件的 valueHtml</button>
    <button @click="setChildValueHtml">设置子组件的 valueHtml</button>
    <!-- 在子组件中通过 props 接收，不需要再使用 :initialValueHtml="initialValueHtml" -->
    <BasicEditor  ref="weditorRef" />
  </div>
</template>

<script setup>
import BasicEditor from "@/components/Editor/BasicEditor.vue";
import { ref } from 'vue';

const weditorRef = ref(null);
const getChildValueHtml = () => {
  console.log("父页面获取到的值", weditorRef.value.valueHtml);
};

const setChildValueHtml = () => {
  weditorRef.value.valueHtml ="<p>初始内容</p>";
};

</script>
