import axios from "axios";
import { chatAction } from "../store/chatSlice";
import store from "../store/store";
import Send from "./send";

const chatURL = "/api/chat";

export const chat = {
  get: {
    room: async (data) => {
      const response = await Send.get(`${chatURL}/room/${data}`);
      return response;
    },
  },
  post: {
    //게시글 상세에서 채팅하기 버튼 클릭
    message: async (data) => {
      const response = await Send.post(`${chatURL}/message`, data);
      return response;
    },
    chat: async (data) => {
      const response = await Send.post(`${chatURL}/room`, data);
      console.log(response);
      store.dispatch(chatAction.setRoomInfo(response));
      store.dispatch(chatAction.setChatOpen(true));
    },
  },
  put: {},
  delete: {},
};
