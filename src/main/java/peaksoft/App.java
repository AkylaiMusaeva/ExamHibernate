package peaksoft;

import peaksoft.config.DatabaseConnection;
import peaksoft.entity.Comment;
import peaksoft.entity.Post;
import peaksoft.entity.Profile;
import peaksoft.entity.User;
import peaksoft.enums.Gender;
import peaksoft.service.CommentService;
import peaksoft.service.PostService;
import peaksoft.service.ProfileService;
import peaksoft.service.UserService;
import peaksoft.service.serviceImpl.CommentServiceImpl;
import peaksoft.service.serviceImpl.PostServiceImpl;
import peaksoft.service.serviceImpl.ProfileServiceImpl;
import peaksoft.service.serviceImpl.UserServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //DatabaseConnection.getEntityManagerFactory();

        CommentService commentService = new CommentServiceImpl();
        PostService postService = new PostServiceImpl();
        ProfileService profileService = new ProfileServiceImpl();
        UserService userService = new UserServiceImpl();
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerWord = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    User
                    1-save user                     8-delete profile by user id           15-update comment
                    2-find user by id               9-save post with user                 16-delete comment
                    3-save profile                  10-get posts by user id
                    4-assign profile to user        11-search post by query
                    5-update user's profile         12-delete post by id
                    6-delete user by id             13-save comment
                    7-find profile by user id       14-find comments by post id
                    
                    """);
            switch (scannerNum.nextInt()){
                case 1->{//done
                    System.out.println("Input user name: ");
                    String username=scannerWord.nextLine();
                    System.out.println("Input user email");
                    String email=scannerWord.nextLine();
                    System.out.println("Input user password: ");
                    String password=scannerWord.nextLine();
                    System.out.println(userService.saveUser(new User(username,email,password)));
                }
                case 2->{//done
                    System.out.println("Input user id you want to find: ");
                    Long id=scannerNum.nextLong();
                    System.out.println(userService.findUserById(id));
                }
                case 3->{//done
                    System.out.println("Input user id ");
                    Long userId=scannerNum.nextLong();
                    System.out.println("Input user's full name ");
                    String fullName=scannerWord.nextLine();
                    System.out.println("Input user's gender :");
                    String gender=scannerWord.nextLine();
                    System.out.println("Input bio of user: ");
                    String bio=scannerWord.nextLine();
                    System.out.println(
                            profileService.saveProfile(userId,
                                    new Profile(fullName,
                                            LocalDate.of(2001,7,18), Gender.valueOf(gender.toUpperCase()),bio)));
                }
                case 4->{//done
                    System.out.println("Input profile id to assign to user ");
                    Long profileId=scannerWord.nextLong();
                    System.out.println("Input user id: ");
                    Long userId=scannerNum.nextLong();
                    System.out.println(profileService.assignProfileToUser(profileId,userId));
                }
                case 5->{
                    System.out.println("Input user id to update his profile");
                    Long userId=scannerNum.nextLong();
                    System.out.println("Input user's new full name ");
                    String fullName=scannerWord.nextLine();
                    System.out.println("Input user's gender :");
                    String gender=scannerWord.nextLine();
                    System.out.println("Input bio of user: ");
                    String bio=scannerWord.nextLine();
                    System.out.println(
                            profileService.updateUserProfile(userId,
                                    new Profile(fullName,
                                            LocalDate.of(2001,7,18), Gender.valueOf(gender.toUpperCase()),bio)));

                }
                case 6->{//done
                    System.out.println("Input user id to delete: ");
                    Long userId=scannerNum.nextLong();
                    System.out.println(userService.deleteUserById(userId));
                }
                case 7->{//done
                    System.out.println("Input user id to find his profile: ");
                    Long id=scannerNum.nextLong();
                    System.out.println(profileService.findProfileByUserId(id));
                }
                case 8->{//done
                    System.out.println("Input user id to delete his/her profile: ");
                    Long userId=scannerNum.nextLong();
                    System.out.println(profileService.deleteProfileByUserId(userId));
                }
                case 9->{//done
                    System.out.println("Input user id to save post: ");
                    Long userId=scannerNum.nextLong();
                    System.out.println("Input post image: ");
                    String image=scannerWord.nextLine();
                    System.out.println("Input post description: ");
                    String description=scannerWord.nextLine();
                    System.out.println(postService.savePost(userId,
                            new Post(image,description,LocalDate.of(2018,12,12))));
                }
                case 10->{//done
                    System.out.println("Input user id to get his posts: ");
                    Long userId=scannerNum.nextLong();
                    System.out.println(postService.getPostsByUserId(userId));
                }
                case 11->{//done
                    String query=scannerWord.nextLine();
                    System.out.println(postService.searchPost(query));
                }
                case 12->{//done
                    System.out.println("Input post id to delete: ");
                    Long id=scannerNum.nextLong();
                    System.out.println(postService.deletePostById(id));
                }
                case 13->{//done
                    System.out.println("Input post id:");
                    Long postId=scannerNum.nextLong();
                    System.out.println("Input user id:");
                    Long userId=scannerNum.nextLong();
                    System.out.println("Input comment text: ");
                    String text=scannerWord.nextLine();
                    System.out.println(commentService.saveComment(postId,userId,
                            new Comment(text,LocalDate.of(2021,12,12))));

                }
                case 14->{
                    System.out.println("Input post id to find comment");
                    Long postId=scannerNum.nextLong();
                    commentService.findCommentByPostId(postId).forEach(System.out::println);
                }
                case 15->{
                    System.out.println("Input comment id to update: ");
                    Long commentID=scannerNum.nextLong();
                    System.out.println("Input new comment: ");
                    String newText=scannerWord.nextLine();
                    System.out.println(commentService.updateComment(commentID,newText));
                }
                case 16->{
                    System.out.println("Input comment text to delete");
                    String text=scannerWord.nextLine();
                    System.out.println(commentService.deleteComment(new Comment(
                            text,LocalDate.of(2021,12,12))));
                }
            }
        }
    }
}
