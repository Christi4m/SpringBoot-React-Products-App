import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./auth.slice";
import productReducer from "./product.slice"; // Asegúrate de que la ruta es correcta

import storage from "redux-persist/lib/storage";
import { persistStore, persistReducer } from "redux-persist";
import { combineReducers } from "redux";

// Configuración de redux-persist
const persistConfig = {
  key: "root",
  storage,
  whitelist: ["auth"], // Solo persiste auth
};

const rootReducer = combineReducers({
  auth: authReducer,
  products: productReducer, // Asegúrate de que 'productReducer' esté definido antes de combinar
});

const persistedReducer = persistReducer(persistConfig, rootReducer);

export const store = configureStore({
  reducer: persistedReducer,
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: false, // Necesario para redux-persist
    }),
});

export const persistor = persistStore(store);

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
