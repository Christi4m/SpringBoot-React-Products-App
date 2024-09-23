import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { RootState } from "./store";
import {
  createProductService,
  fetchProductsService,
} from "../service/product.service";

interface ProductData {
  price: number;
  color: string;
}

interface Product {
  name: string;
  brand: string;
  data: ProductData[];
}

interface ProductState {
  products: Product[];
  status: "idle" | "loading" | "succeeded" | "failed";
}

const initialState: ProductState = {
  products: [],
  status: "idle",
};

export const fetchProducts = createAsyncThunk(
  "products/fetchProducts",
  async (_, { getState }) => {
    const state = getState() as RootState;
    const token = state.auth.token;
    return await fetchProductsService(token!);
  }
);

export const createProduct = createAsyncThunk(
  "products/createProduct",
  async (product: Product, { getState }) => {
    const state = getState() as RootState;
    const token = state.auth.token;
    return await createProductService(product, token!);
  }
);

const productSlice = createSlice({
  name: "products",
  initialState,
  reducers: {
    addProduct: (state, action) => {
      state.products.push(action.payload);
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(fetchProducts.pending, (state) => {
        state.status = "loading";
      })
      .addCase(fetchProducts.fulfilled, (state, action) => {
        state.status = "succeeded";
        state.products = action.payload;
      })
      .addCase(fetchProducts.rejected, (state) => {
        state.status = "failed";
      })
      .addCase(createProduct.pending, (state) => {
        state.status = "loading";
      })
      .addCase(createProduct.fulfilled, (state, action) => {
        state.status = "succeeded";
        state.products.push(action.payload);
      })
      .addCase(createProduct.rejected, (state) => {
        state.status = "failed";
      });
  },
});

export const { addProduct } = productSlice.actions;
export default productSlice.reducer;
