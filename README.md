# 그룹웨어 게시판 작성

### 게시판 시연 유튜브 채널
- [https://www.youtube.com/watch?v=BmjdlsGum1w](https://www.youtube.com/watch?v=BmjdlsGum1w)

- #### 개발 환경
  - ##### IDE(Eclipse Neon) 
  - ##### JDK1.8
  - ##### Tomcat 9
  - ##### Spring 5.3.27
  - ##### Maven 3.3.2
  - ##### DBeaver 24.1.0

```bash
// src/swagger.ts

import swaggerJSDoc from 'swagger-jsdoc';

const options = {
  definition: {
    openapi: '3.0.0', // OpenAPI 스펙 버전
    info: {
      title: '익명 게시판 API',
      version: '1.0.0',
    },
    components: {
      schemas: {
        Post: {
          type: 'object',
          properties: {
            id: { type: 'integer' },
            title: { type: 'string' },
            content: { type: 'string' },
            authorName: { type: 'string' },
            createdAt: { type: 'string', format: 'date-time' },
            updatedAt: { type: 'string', format: 'date-time' },
          },
          required: [
            'id',
            'title',
            'content',
            'authorName',
            'createdAt',
            'updatedAt',
          ],
        },
        PostInput: {
          type: 'object',
          properties: {
            title: { type: 'string' },
            content: { type: 'string' },
            authorName: { type: 'string' },
            password: { type: 'string' },
          },
          required: ['title', 'content', 'authorName', 'password'],
        },
        PostUpdateInput: {
          type: 'object',
          properties: {
            title: { type: 'string' },
            content: { type: 'string' },
            password: { type: 'string' },
          },
          required: ['title', 'content', 'password'],
        },
        Comment: {
          type: 'object',
          properties: {
            id: { type: 'integer' },
            content: { type: 'string' },
            authorName: { type: 'string' },
            createdAt: { type: 'string', format: 'date-time' },
            postId: { type: 'integer' },
            parentId: { type: 'integer', nullable: true },
          },
          required: ['id', 'content', 'authorName', 'createdAt', 'postId'],
        },
        CommentWithReplies: {
          type: 'object',
          allOf: [{ $ref: '#/components/schemas/Comment' }],
          properties: {
            replies: {
              type: 'array',
              items: { $ref: '#/components/schemas/Comment' },
            },
          },
        },
        CommentInput: {
          type: 'object',
          properties: {
            content: { type: 'string' },
            authorName: { type: 'string' },
            parentId: { type: 'integer', nullable: true },
            password: { type: 'string' },
          },
          required: ['content', 'authorName'],
        },
        CommentUpdateInput: {
          type: 'object',
          properties: {
            content: { type: 'string' },
            password: { type: 'string' },
          },
          required: ['content', 'password'],
        },
        Error: {
          type: 'object',
          properties: {
            message: { type: 'string' },
          },
        },
      },
    },
  },
  apis: ['./src/routes/*.ts'], // 라우트 파일에서 Swagger 주석을 읽어 옴
};

const specs = swaggerJSDoc(options);
export default specs;
```
