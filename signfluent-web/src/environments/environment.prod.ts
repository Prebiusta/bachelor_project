export const environment = {
  production: true,
  // @ts-ignore
  apiHost: window["env"]["apiHost"] || "localhost",
  // @ts-ignore
  apiPort: window["env"]["apiPort"] || "8006",
};
