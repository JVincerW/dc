<template>
  <BasicEditor ref="wEditorRef"/>
</template>

<script setup>
import BasicEditor from "@/components/Editor/BasicEditor.vue";

const wEditorRef = ref();

const getChildValueHtml = () => {
  console.log("父页面获取到的值", wEditorRef.value.valueHtml);
};

const setChildValueHtml = () => {
  wEditorRef.value.valueHtml = "<p>初始内容</p>";
};
</script>

<style scoped>

</style>
