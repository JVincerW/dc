<script setup>
import {Plus} from '@element-plus/icons-vue'

const articTypes = ['分类1', '分类2', '分类3', '分类4', '分类5']
const tags = ref([
  {id: 1, type: '', label: 'java', flag: false},
  {id: 2, type: 'success', label: 'vue', flag: false},
  {id: 3, type: 'info', label: '博客', flag: false},
  {id: 4, type: 'danger', label: '生活', flag: false},
  {id: 5, type: 'warning', label: '感悟', flag: false}
]);
const dialogTableVisible = true
const uploadFile = () => {
  console.log("ddd")
}
const tag = (clickedTag) => {
  clickedTag.flag = !clickedTag.flag;
};
const handleCancel = () => {
  console.log("ddd2")
}
const handleSubmit = () => {
  console.log("ddd1")
}

</script>

<template>
  <el-dialog
      title="文章信息"
      :visible.sync="false"
      v-model="dialogTableVisible"
      width="30%"
      center>
    <el-form label-width="80px">
      <el-form-item label="阅读类型">
        <el-radio-group>
          <el-radio :label="0">无需验证</el-radio>
          <el-radio :label="1">评论阅读</el-radio>
          <el-radio :label="2">点赞阅读</el-radio>
          <el-radio :label="3">扫码阅读</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="文章分类">
        <el-select placeholder="请选择分类">
          <el-option
              v-for="item in articTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="文章标签" form.tags>
        <el-tag
            v-for="item in tags"
            style="cursor: pointer;margin-left: 10px" :type="item.flag?'info':'success'"
            effect="dark" @click="tag(item)"
            :key="item.id">
          {{ item.label }}
        </el-tag>
      </el-form-item>
      <el-form-item label="封面图片">
        <el-upload
            class="avatar-uploader"
            action="#"
            :limit="1"
            :show-file-list="false"
            :http-request="uploadFile"
        >
          <img v-if="false" src="https://img-blog.csdnimg.cn/d658f31b81f84566be9de5b6db880b82.png" class="avatar" alt="ggg"/>
          <el-icon v-else class="avatar-uploader-icon">
            <Plus/>
          </el-icon>
        </el-upload>

      </el-form-item>
      <el-form-item>
        <el-button @click="handleCancel">取消</el-button>
        <el-button type="primary" @click="handleSubmit">确认</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<style scoped lang="scss">
.f_r {
  position: fixed;
  width: auto;
  bottom: 40px; /* 距离底部的距离，根据需要调整 */
  right: 60px; /* 距离右边的距离，根据需要调整 */
}

.inputDeep :deep(.el-input__inner) {
  border: 0;
  font-size: 2em;
  height: 40px;
  text-align: center;
  border-bottom: 1px solid #ccc;
  margin-bottom: 10px;
}

.disabled .el-upload--picture-card {
  display: none;
}
</style>

<style scoped>
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>
