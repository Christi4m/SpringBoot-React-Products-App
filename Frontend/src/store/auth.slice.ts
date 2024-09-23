import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import { loginService } from "../service/auth.service";

interface AuthState {
  token: string | null;
  isAuthenticated: boolean;
  status: "idle" | "loading" | "succeeded" | "failed";
}

const initialState: AuthState = {
  token: null,
  isAuthenticated: false,
  status: "idle",
};

export const login = createAsyncThunk(
  "auth/login",
  async (credentials: { username: string; password: string }) => {
    return await loginService(credentials);
  }
);

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    setAuth: (state, action: PayloadAction<string>) => {
      state.token = action.payload;
      state.isAuthenticated = true;
    },
    logout: (state) => {
      state.token = null;
      state.isAuthenticated = false;
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(login.pending, (state) => {
        state.status = "loading";
      })
      .addCase(login.fulfilled, (state, action: PayloadAction<string>) => {
        state.token = action.payload;
        state.isAuthenticated = true;
        state.status = "succeeded";
      })
      .addCase(login.rejected, (state) => {
        state.status = "failed";
      });
  },
});

export const { setAuth, logout } = authSlice.actions;

export default authSlice.reducer;
