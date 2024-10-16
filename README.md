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
 - #####

