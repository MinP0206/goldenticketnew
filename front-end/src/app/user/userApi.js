import { axiosClient, baseURL } from "../axiosClient";

export const userApi = {
  signUp(formValue) {
    const url = `${baseURL.user}/signup`;
    return axiosClient.post(url, formValue);
  },
  signIn(formValue) {
    const url = `${baseURL.user}/signin`;
    console.log("login nè");
    return axiosClient.post(url, formValue);
  },
};
