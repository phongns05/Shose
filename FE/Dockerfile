#FROM node:16 AS build
#WORKDIR /app
#COPY package.json /app/package.json
#COPY package-lock.json /app/package-lock.json
#RUN npm install -f
#COPY . /appS
#
#RUN npm run build


#FROM nginx:1.21.4-alpine
#
## Copy the built React app from the "build" stage
#COPY --from=build /app/build /usr/share/nginx/html
#
## Copy the Nginx configuration
#COPY /nginx/nginx.conf /etc/nginx/conf.d/default.conf
#
## Set the entry point to start Nginx
#CMD ["nginx", "-g", "daemon off;"]

FROM node:16 AS build

WORKDIR /app

COPY package.json /app/package.json

COPY package-lock.json /app/package-lock.json

RUN npm install -f

COPY . /app

RUN npm run build

EXPOSE 3000

ENTRYPOINT ["npx", "serve", "-s", "build", "-l", "3000"]