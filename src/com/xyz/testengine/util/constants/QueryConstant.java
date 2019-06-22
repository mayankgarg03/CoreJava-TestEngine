package com.xyz.testengine.util.constants;

public interface QueryConstant {

       String LOGIN_SQL = " select users_mst.username , role_mst.name as rolename , right_mst.name as rightname , right_mst.screenname"
       		+ " from users_mst , role_mst , right_mst , user_role_mapping , role_right_mapping"
       		+ " where users_mst.uid=user_role_mapping.uid and role_mst.roleid=user_role_mapping.roleid "
       		+ "and role_mst.roleid=role_right_mapping.roleid and right_mst.rightid=role_right_mapping.rightid "
       		+ "and users_mst.username = ? and users_mst.password=?";
       String REGISTER_SQL = "insert into users_mst (username , password, emailid, confirmpassword, selectcity, dateofbirth, gender, "
       		+ "selectcollege, selectstream, selectusertype, phoneno,rollno) values(?,?,?,?,?,?,?,?,?,?,?,?)";
       String QUESTION_UPLOAD_SQL = "insert into question (question_no,question,ans1,ans2,ans3,ans4,rans,score) values(?,?,?,?,?,?,?,?)";
       String QUESTION_INSERT_SQL = "select question.question_no,question.qid,question.question ,question.ans1,"
       		+ "question.ans2,question.ans3,question.ans4,question.rans,question.score "
       		+ "from question,test,question_test_map where test.testid=question_test_map.testid and "
       		+ "question_test_map.qid=question.qid  and testname=?";
	
        String FETCH_TESTNAME_SQL = " select testname from test";
        String CHECK_TESTID_SQL = "select testno from test";
        String SEARCH_SQL = "select * from users_mst where emailid = ? or phoneno = ? ";
        String FETCH_SQL = "select uid,username , password,emailid, confirmpassword,selectcity,"
        		+ "dateofbirth,gender,selectcollege,selectstream,selectusertype,phoneno,rollno "
        		+ "from users_mst where authentication = 'no'";
        String FETCH_ROLE_SQL = "select uid,username , password,emailid, confirmpassword,selectcity,"
        		+ "dateofbirth,gender,selectcollege,selectstream,selectusertype,phoneno,rollno "
        		+ "from users_mst where status = 'y'";
        String UPDATE_AUTHENTICATION_SQL = "update users_mst set authentication = ? where emailid = ?";
        String UPDATE_TEST_SQL = "insert into test(testname,testtime) values(?,?)";
        String FIND_TEST_SQL = "select * from test where testname = ?";
        String FETCH_UNMAP_SQL = "select qid,question_no , question , ans1 , ans2  , ans3 , ans4 ,  "
        		+ "rans,score from question where  status = 'N' ";
        String FETCH_MAP_SQL = "select qid,question_no , question , ans1 , ans2  , ans3 , ans4 ,  "
        		+ "rans,score from question";
        String GET_TESTID_SQL = "select testid from test where testname = ?";
        String QUES_TEST_MAP_SQL = "insert into question_test_map(qid , testid) values(?,?)";
        String STATUS_UPDATE_SQL = "update question set status = ? where qid = ?";
        String FETCH_TIME_SQL = "select testtime from test where testname = ?";
        String SET_USER_ROLE_SQL = "insert into user_role_mapping(uid, roleid) values(?,?)";
        String STATUS_ROLE_UPDATE_SQL = "update users_mst set status = 'N' where uid = ?";
        String FETCH_RIGHT_SQL = "select rightid,name,screenname from right_mst";
        String SET_USER_RIGHT_SQL = "insert into role_right_mapping( roleid , rightid) values(?,?)";
       
        }
