import { defineConfig, loadEnv } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite'
import path from 'path'

// https://vite.dev/config/
export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd(), '')
  
  return {
    plugins: [
      react(),
      tailwindcss(),
    ],
    server: {
      proxy: {
        '/api/v1': {
          target: env.VITE_API_PROXY_URL || 'http://localhost:8081',
          changeOrigin: true,
        },
        '/oauth2/authorization': {
          target: env.VITE_API_PROXY_URL || 'http://localhost:8081',
          changeOrigin: true,
        },
        '/login/oauth2': {
          target: env.VITE_API_PROXY_URL || 'http://localhost:8081',
          changeOrigin: true,
        }
      }
    },
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"),
    },
  },
  };
})

