<template>
	<el-tag
			v-for='tag in dynamicTags'
			:key='tag'
			:disable-transitions='false'
			class='mx-1'
			closable
			@close='handleClose(tag)'
	>
		{{tag}}
	</el-tag>
	<el-input
			v-if='inputVisible'
			ref='InputRef'
			v-model='inputValue'
			size='small'
			style='width: 5rem;margin-left: 0.25rem;'
			@blur='handleInputConfirm'
			@keyup.enter='handleInputConfirm'
	/>
	<el-button v-else class='button-new-tag margin-left: 0.25rem;' size='small' @click='showInput'>
		+ New Tag
	</el-button>
</template>

<script lang='ts' setup>
import { nextTick, ref } from 'vue';
import { ElInput } from 'element-plus';

const inputValue = ref('');
const dynamicTags = ref(['Tag 1', 'Tag 2', 'Tag 3']);
const inputVisible = ref(false);
const InputRef = ref<InstanceType<typeof ElInput>>();

const handleClose = (tag: string) => {
	dynamicTags.value.splice(dynamicTags.value.indexOf(tag), 1);
};

const showInput = () => {
	inputVisible.value = true;
	nextTick(() => {
		InputRef.value!.input!.focus();
	});
};

const handleInputConfirm = () => {
	if (inputValue.value) {
		dynamicTags.value.push(inputValue.value);
	}
	inputVisible.value = false;
	inputValue.value = '';
};
</script>
