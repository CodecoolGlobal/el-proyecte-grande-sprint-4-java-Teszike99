#syntax=docker/dockerfile:1
FROM node:12.18.1

WORKDIR /app
COPY package-lock.json ./
COPY package.json ./
COPY . ./
RUN npm install

CMD ["npm", "start"]