package com.example.blog.controller;


import com.example.blog.entity.dto.BlogDto;
import com.example.blog.entity.dto.CategoryDto;
import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;


@RestController
public class HomeController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Blog>> showHomePage() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> showCategoryList() {
        List<Category> categoryList = categoryService.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for(Category c :categoryList){
            CategoryDto categoryDto = new CategoryDto();

            categoryDto.setId(c.getId());
            categoryDto.setName(c.getName());

            categoryDtoList.add(categoryDto);
        }
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<BlogDto>> showBlogList(){
        List<Blog> blogList = blogService.findAll();
        List<BlogDto> blogDtoList = new ArrayList<>();
        for(Blog b : blogList){
            BlogDto blogDto = new BlogDto();
            blogDto.setId(b.getId());
            blogDto.setName(b.getName());
            blogDto.setContent(b.getContent());
            blogDto.setPostDate(b.getPostDate());
            blogDtoList.add(blogDto);
        }
        return new ResponseEntity<>(blogDtoList, HttpStatus.OK);
    }

    @GetMapping("/blog-category/{id}")
    public ResponseEntity<List<BlogDto>> showBlogInCategory(@PathVariable int id){
        Category category = categoryService.findById(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Blog> blogList = category.getList();
        List<BlogDto> listBlogDtoInCategory = new ArrayList<>();
        for (Blog blog : blogList){
            BlogDto blogDto = new BlogDto();
            blogDto.setId(blog.getId());
            blogDto.setName(blog.getName());
            blogDto.setContent(blog.getContent());
            blogDto.setPostDate(blog.getPostDate());
            listBlogDtoInCategory.add(blogDto);
        }
        return new ResponseEntity<>(listBlogDtoInCategory,HttpStatus.OK);
    }

    @GetMapping("/blog-detail/{id}")
    public ResponseEntity<BlogDto> showBlogDetail(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blog.getId());
        blogDto.setName(blog.getName());
        blogDto.setPostDate(blog.getPostDate());
        blogDto.setContent(blog.getContent());
        return new ResponseEntity<>(blogDto,HttpStatus.OK);
    }
}
