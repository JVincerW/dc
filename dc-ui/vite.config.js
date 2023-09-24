import { defineConfig, loadEnv } from 'vite';
import path from 'path';
import createVitePlugins from './vite/plugins';

// https://vitejs.dev/config/
export default defineConfig(({ mode, command }) => {
	const env                                   = loadEnv(mode, process.cwd());
	const { VITE_APP_ENV, VITE_APP_SERVER_API } = env;
	return {
		// 例如 https://www.ruoyi.vip/。如果应用被部署在一个子路径上，你就需要用这个选项指定这个子路径。例如，如果你的应用被部署在 https://www.ruoyi.vip/admin/，则设置 baseUrl 为 /admin/。
		base: VITE_APP_ENV === 'production' ? '/' : '/',
		plugins: createVitePlugins(env, command === 'build'),
		resolve: {
			alias: {
				// 设置路径
				'~': path.resolve(__dirname, './'),
				// 设置别名
				'@': path.resolve(__dirname, './src'),
			},
			extensions: [ '.mjs', '.js', '.ts', '.jsx', '.tsx', '.json', '.vue' ],
		},
		server: {
			port: 80,
			host: true,
			open: true,
			proxy: {
				'/dev-api': {
					target: VITE_APP_SERVER_API,
					changeOrigin: true,
					rewrite: (p) => p.replace(/^\/dev-api/, ''),
				},
			},
		},
		css: {
			postcss: {
				plugins: [
					{
						postcssPlugin: 'internal:charset-removal',
						AtRule: {
							charset: (atRule) => {
								if( atRule.name === 'charset' ) {
									atRule.remove();
								}
							},
						},
					},
				],
			},
		},
	};
});
