import request from '@/utils/request';

export function uploadFileRequest(data) {
	return request({
		url: '/upload',
		method: 'post',
		data: data,
	});
}
