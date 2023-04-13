package com.it.utils;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @program
 * @description 用户登录信息 拦截器
 */
public class JWTAuthLoginFilter extends UsernamePasswordAuthenticationFilter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    public JWTAuthLoginFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//        //设置登录请求的url
//        super.setFilterProcessesUrl("/lab/login");
//    }
//
//
//    @SneakyThrows
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request,
//                                                HttpServletResponse response) throws AuthenticationException {
//
//        // 从输入流中获取到登录的信息
//        try {
//            Login loginUser = new ObjectMapper().readValue(request.getInputStream(), Login.class);
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword(), new ArrayList<>()));
//
//            //密码错误时抛出异常
//        }catch (BadCredentialsException b){
//            System.out.println("密码错误");
//            try {
//                response.setCharacterEncoding("UTF-8");
//                response.setContentType("application/json; charset=utf-8");
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("密码错误");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//            //无此用户时抛出异常
//        }catch (InternalAuthenticationServiceException i){
//            System.out.println("没有此用户");
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json; charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write("xxx");
//            return null;
//        }
//
//        catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    // 成功验证后调用的方法
//    // 如果验证成功，就生成token并返回
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        System.out.println("登录成功");
//        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
//        System.out.println("jwtUser:" + jwtUser.toString());
//        String role = "";
//        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
//        for (GrantedAuthority authority : authorities) {
//            role = authority.getAuthority();
//        }
//        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), role);
//        // 返回创建成功的token
//        // 但是这里创建的token只是单纯的token
//        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
//        System.out.println(token);
//        response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
//        //这里我还将该用户的id进行返回了
//        response.setIntHeader("id",jwtUser.getId().intValue());
//    }
}