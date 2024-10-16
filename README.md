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

- #### 여러개의 Dao를 활용하여 Service 구현
```bash
@Override
	public LikeVo likeCount(LikeVo vo) {
		Map<String, Object>map = new HashMap<String, Object>(){{
			put("bo_no", vo.getBo_no());
			put("emp_no",vo.getEmp_no());
		}};
		int n = dao.likeSearchBoardOne(map);
		if(n==0) {
			dao.likeInsert(map);
			System.out.println("생성됨");
		}else {
			dao.likeDel(map);
			System.out.println("삭제됨");
		}
		LikeVo resultVo = dao.likeSelectOne(vo.getBo_no(),vo.getEmp_no());
		return resultVo;
	}
```

 - #### 게시판 시연 이미지
    - ##### 공지게시판 ![image](https://github.com/user-attachments/assets/d1772b96-c6d4-4d38-abba-614c437ec8e3)
    - ##### 글작성 ![image](https://github.com/user-attachments/assets/dcda8df2-76b0-40c0-83ec-b3cd9c1df96d)
    - ##### 글수정 - 수정 전 ![image](https://github.com/user-attachments/assets/2b1c30b6-8dc0-45d2-a3fc-6d052bf6a9be)
    - ##### 글수정 - 수정 후 ![image](https://github.com/user-attachments/assets/63b4445a-3dbe-4d58-9584-2b4be7b7f280)
    - ##### 삭제게시판 - 삭제 전 ![image](https://github.com/user-attachments/assets/1b68753c-4874-4823-83e4-8e14840dea34)
    - ##### 삭제게시판 - 삭제 후 ![image](https://github.com/user-attachments/assets/aa16b576-ee78-49ac-80d2-14fabe1a7f96)
    - ##### 게시글 완전 삭제(전) ![image](https://github.com/user-attachments/assets/4f20b61d-1f8a-418b-98f9-10df3821e7bd)
    - ##### 게시글 완전 삭제(후) ![image](https://github.com/user-attachments/assets/fb187129-8df4-45d0-b043-266a9eaf8ed2)
    - ##### 게시글 복구(전) ![image](https://github.com/user-attachments/assets/77828b74-69b7-49aa-ba88-755d55266c16)
    - ##### 게시글 복구(후) ![image](https://github.com/user-attachments/assets/82159dd2-fea6-47bf-b600-eb43c2572941)








