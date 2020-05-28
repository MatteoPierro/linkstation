FROM node:12-alpine3.10 as BUILD_IMAGE
WORKDIR /app/
COPY . .
RUN npm install && npm run build

FROM node:12-alpine3.10
WORKDIR /app
COPY --from=BUILD_IMAGE /app/dist ./
CMD ["node", "index.js"]