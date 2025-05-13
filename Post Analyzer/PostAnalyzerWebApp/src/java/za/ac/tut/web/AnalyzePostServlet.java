package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.PostFacadeLocal;
import za.ac.tut.bl.PostUserFacadeLocal;
import za.ac.tut.entities.Post;
import za.ac.tut.models.AILanguageModel;

/**
 *
 * @author Tk
 */
public class AnalyzePostServlet extends HttpServlet {

    @EJB
    PostUserFacadeLocal pufl;
    
    @EJB
    PostFacadeLocal pfl;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String userid = req.getParameter("userid");
        String content = req.getParameter("content");
        Double actualScore = 0.0;
        
        Post post = createPost(id,userid,content,actualScore);
        //AI Model Analysis
        AILanguageModel aiLanguageModel = new AILanguageModel(content);
        Double postRating = Double.parseDouble(aiLanguageModel.getResponse());
        post.setPredicatedScore(postRating);
        pfl.create(post);
        
        
        
        req.getSession().setAttribute("post", post);
        
        RequestDispatcher rd = req.getRequestDispatcher("analyze_post_outcome.jsp");
        rd.forward(req, resp);
        
    }

    private Post createPost(Long id, String userid, String content, Double actualScore) {
        Post post = new Post();
        
        post.setId(id);
        post.setUserid(id);
        post.setContent(content);
        post.setActualScore(actualScore);
        
        
        return post;
    }
    
    
    
}
