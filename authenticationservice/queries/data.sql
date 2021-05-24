# delete from oauth_access_token;
# delete from oauth_approvals;
# delete from oauth_client_details;
# delete from oauth_client_token;
# delete from oauth_code;
# delete from oauth_refresh_token;
# delete from permission_role;
# delete from permission;
# delete from role_user;
# delete from role;
# delete from user;

# INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('mobile', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8080/code', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');
#
# INSERT INTO PERMISSION (NAME) VALUES
# ('create_profile'),
# ('read_profile'),
# ('update_profile'),
# ('delete_profile');
#
# INSERT INTO role (id, name) VALUES
# (1,'ROLE_admin'),(2,'ROLE_operator');

# INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
# (5,1), /*create-> admin */
# (6,1), /* read admin */
# (7,1), /* update admin */
# (8,1), /* delete admin */
# (6,2),  /* read operator */
# (7,2);  /* update operator */
# insert into user (username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('krish','{bcrypt}$2a$10$ODGwrk2ufy5d7T6afmACwOA/6j6rvXiP5amAMt1YjOQSdEw44QdqG', 'k@krishantha.com', true, true, true, true);
# insert into  user (username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('suranga', '{bcrypt}$2a$10$wQ8vZl3Zm3.zDSIcZEYym.bGq3fPMJXH9k.Vhudcfr6O6KQwDPSt6','k@krishantha.com', true, true, true, true);

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
VALUES
(1, 3) /* krish-admin */,
(2, 4) /* suranga-operatorr */ ;