<script setup>

import {getDicts} from "@/api/system/dict/data";
import {defineProps, ref} from 'vue';

const props = defineProps({dialogTableVisible: Boolean, editorData: Object});
const editorData = props.editorData;
const articTypes = ['分类1', '分类2', '分类3', '分类4', '分类5'];
const selectedCoverImages = ref([]);
const tags = ref([])
const dialogTableVisible = ref(false);
let selectedReadType = ref(0);
let selectedCategory = ref(articTypes[0]);
const handleShow = () => {
    dialogTableVisible.value = true;
    initTags()
};
const tag = (clickedTag) => {
    clickedTag.flag = !clickedTag.flag;
};
// 计算属性
const selectedTagsLabel = computed(() => {
    return tags.value.filter((tag) => tag.flag).map((tag) => tag.dictLabel);
});
const initTags = () => {
    getDicts("artic_tags").then(resp => {
        const tags_tmp = resp.data
        tags_tmp.map((tag) => tag.flag = false)
        tags.value = resp.data

        console.log(tags.value);
    });
}
const handleCancel = () => {
    dialogTableVisible.value = false;
};

const handleSubmit = () => {
    console.log('选择的阅读类型：', selectedReadType.value);
    console.log('选择的文章分类：', selectedCategory.value);
    console.log('选择的文章标签：', selectedTagsLabel.value);
    console.log('选择的封面图片：', selectedCoverImages.value);
    console.log(editorData, 'editorData');


};
defineExpose({handleShow});
</script>

<template>
    <el-dialog v-model='dialogTableVisible' center title='文章信息' width='30%'>
        <el-form label-width='80px'>
            <el-form-item label='阅读类型'>
                <el-radio-group v-model='selectedReadType'>
                    <el-radio :label='0'>无需验证</el-radio>
                    <el-radio :label='1'>评论阅读</el-radio>
                    <el-radio :label='2'>点赞阅读</el-radio>
                    <el-radio :label='3'>扫码阅读</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label='文章分类'>
                <el-select v-model='selectedCategory' placeholder='请选择分类'>
                    <el-option v-for='item in articTypes' :key='item' :label='item' :value='item'></el-option>
                </el-select>
            </el-form-item>


            <el-form-item form.tags label='文章标签'>
                <el-tag
                    v-for='item in tags'
                    :key='item.code'
                    :type="item.flag ? 'success':'info'"
                    effect='dark'
                    style='cursor: pointer; margin-left: 10px'
                    @click='tag(item)'
                >
                    {{ item.dictLabel }}
                </el-tag>
            </el-form-item>
            <el-form-item label='封面图片'>
                <image-upload
                    ref='upi'
                    v-model='selectedCoverImages'
                    :fileSize='20'
                    :fileType="['png', 'jpg', 'jpeg']"
                    :isShowTip='true'
                    :limit='1'
                />
            </el-form-item>
            <el-form-item>
                <el-button @click='handleCancel'>取消</el-button>
                <el-button type='primary' @click='handleSubmit'>确认</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
</template>

