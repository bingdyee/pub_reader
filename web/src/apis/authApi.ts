import request, {DataResponse} from "@/lib/request";
import {User} from "next-auth";

// 登录
export const login = (username: string, password: string, loginType: string) => {
  return request.post<DataResponse<User>>("/v1/auth/login", {
    params: { username, password, loginType },
    cacheTime: 0
  })
}
