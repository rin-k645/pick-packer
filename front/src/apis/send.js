import axios from 'axios';

const instance = axios.create({
  baseURL: 'https://j8b307.p.ssafy.io/',
  timeout: 2000,
  headers: {
    'Content-Type': 'application/json',
  },
});
instance.interceptors.request.use(
  // 요청 전
  (config) => {
    // "세션 스토리지에 토큰 있는지 검사 후 있다면 넣어주는 것"

    // const storage = JSON.parse(sessionStorage.getItem('recoil-persist'));
    // if (
    //   storage === null ||
    //   !Object.keys(storage).includes('accessToken') ||
    //   storage.accessToken === ''
    // ) {
    //   config.headers.Authorization = null;
    // } else {
    //   config.headers.Authorization = `Bearer ${storage.accessToken}`;
    // }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  },
);

instance.interceptors.response.use(
  (config) => {
    return config.data;
  },
  (error) => {
    return Promise.reject(error);
  },
);

export default instance;

