<template>
  <p>Vue3 wangEditor</p>
  <button @click="getChildValueHtml">获取子组件的 valueHtml</button>
  <button @click="setChildValueHtml">设置子组件的 valueHtml</button>
  <div class="eP">
    <BasicEditor class="eEcon" ref="wEditorRef"/>
  </div>
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
<style>
.eEcon {
  border: 1px solid #f00;

}

.eP {
  width:100vw;
  height:500px;
  border: 1px solid #ff0
}
</style>
