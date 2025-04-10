import type { NextConfig } from 'next'

const nextConfig: NextConfig = {
  reactStrictMode: true,
  output: 'standalone',
  images: {
    remotePatterns: [
      { protocol: 'http', hostname: 'localhost', port: '9000' }, // minio
    ],
  },
  eslint: {
    ignoreDuringBuilds: true,
  },
  logging: {
    fetches: {
      fullUrl: true,
    },
  },
}

export default nextConfig
