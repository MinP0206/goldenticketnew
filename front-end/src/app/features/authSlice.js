import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { userApi } from "../user/userApi";

export const login = createAsyncThunk(
  "auth/signin",
  async ({ formValue, navigate, toast }, { rejectWithValue }) => {
    try {
      const response = await userApi.signIn(formValue);
      console.log('response: ',response);
      toast.success("Login Successfully");
      navigate("/");
      
      return response;
    } catch (err) {
      return rejectWithValue(err.response.data);
    }
  }
);

export const register = createAsyncThunk(
  "auth/signup",
  async ({ formValue, navigate, toast }, { rejectWithValue }) => {
    try {
      const response = await userApi.signUp(formValue);
      toast.success("Register Successfully");
      navigate("/");
      return response;
    } catch (err) {
      return rejectWithValue(err.response.data);
    }
  }
);

const userSlice = createSlice({
  name: "auth",
  initialState: {
    userInfo: null,
    password: "",
    isLoading: false,
    isSuccess: false,
    errorMessage: "",
  },
  reducers: {
    setUser: (state, action) => {
      state.userInfo = action.payload;
    },
    setPassword: (state, action) => {
      state.password = action.payload;
    },
    setLogout: (state, action) => {
      localStorage.clear();
      state.userInfo = null;
      state.errorMessage = null;
      state.isError = false;
    },
    resetError: (state) => {
      state.errorMessage = null;
    },
  },
  extraReducers: {
    [login.pending]: (state, action) => {
      state.isLoading = true;
    },
    [login.fulfilled]: (state, action) => {
      state.isLoading = false;
      localStorage.setItem(
        "accessToken",
        JSON.stringify({ ...action.payload })
      );
      state.userInfo = action.payload;
    },
    [login.rejected]: (state, action) => {
      state.isLoading = false;
      state.isSuccess = false;
      state.errorMessage = action.payload;
    },
    [register.fulfilled]: (state, action) => {
      state.isLoading = false;
      state.isSuccess = true;
      state.userInfo = action.payload;
    },
    [register.pending]: (state) => {
      state.isLoading = true;
    },
    [register.rejected]: (state, { payload }) => {
      state.isLoading = false;
      state.isSuccess = false;
      state.errorMessage = payload;
    },
  },
});

export const { setUser, setLogout, resetError, setPassword } =
  userSlice.actions;
export default userSlice.reducer;
