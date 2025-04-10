import NextAuth, {NextAuthConfig} from "next-auth";
import Credentials from "next-auth/providers/credentials";

import {login} from "@/apis/authApi";


export const LOGIN_PATH = "/login";

const authConfig: NextAuthConfig = {
  pages: {
    signIn: LOGIN_PATH
  },
  session: {
    strategy: "jwt",
    maxAge: 15 * 24 * 60 * 60 // 15 days
  },
  callbacks: {
    jwt({ token, user }) {
      if (user) token.role = user.role
      return token
    },
    session({ session, token }) {
      return {
        ...session,
        user: {
          ...session.user,
          id: token.sub,
          role: token.role,
        }
      }
    }
  },
  providers: [
    Credentials({
      name: "Credentials",
      credentials: {
        username: { label: "手机/邮箱", type: "text" },
        password: { label: "密码", type: "password" },
        loginType: { label: "登录类型", type: "text" },
      },
      async authorize(credentials, req) {
        const loginType = credentials.loginType as string
        const uname = credentials.username as string;
        const pass = credentials.password as string
        const resp = await login(uname, pass, loginType)
        if (!resp.success) {
          return null
        } 
        return resp.data
      }
    })
  ]
}

export const {auth, handlers, signIn, signOut} = NextAuth(authConfig)
