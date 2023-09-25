<template>
    <div>
        <el-button class="push" type="success" icon="Promotion" circle @click="getChildValueHtml"/>
        <div>
            <BasicEditor :editorData="editorData" ref="wEditorRef"/>
            <dig ref="dig"></dig>
        </div>
    </div>

</template>

<script setup>
import BasicEditor from '@/components/Editor/BasicEditor.vue';
import Dig from '@/views/blogs/wEditor/C/dig.vue';
const wEditorRef = ref()
const dig=ref()
const editorData = {
    isInit: true,
    isOnlyRead: false,
    valueHtml: '<p>初始内容</p>',
    hasTitle: true,
    title: "初始化标题"
};

const getChildValueHtml = () => {
    console.log('父页面获取到的值', wEditorRef.value.initEditor);
    dig.value.handleShow();
};

</script>

<style scoped>
.push {
    position: absolute;
    bottom: 39px;
    right: 80px;
    z-index: 99;
}
</style>
