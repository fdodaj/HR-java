package main;

public enum RoleEnum {
    EMPLOYEE(1, "EMPLOYEE"),
    HR(2, "EMPLOYEE"),
    PD(3, "EMPLOYEE"),
    ADMIN(4, "EMPLOYEE");

    private String name;
    private int code;

    public int getRoleCodeByRoleName(String roleName) {
        return RoleEnum.valueOf(roleName).getCode();
    }

    public RoleEnum getRole(int code) {
        return getRole(code);
    }

    public static RoleEnum getById(int id) {
        for(RoleEnum e : values()) {
            if(e.code==id) return e;
        }
        return null;
    }




    RoleEnum(int code, String role) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
