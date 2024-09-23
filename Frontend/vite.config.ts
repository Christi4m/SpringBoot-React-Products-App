import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vitejs.dev/config/
export default defineConfig({
  base: "/SpringBoot-React-Products-App/Frontend",
  plugins: [react()],
});
