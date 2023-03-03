<template>
  <div id="aa">
  <el-menu class="el-menu-vertical-demo" 
        :collapse="this.$store.state.isCollapse" 
        :router="isRouter"
        background-color="#163e6a"
        text-color="white"
        active-text-color="#559867"
        >
          <el-sub-menu index="1">
            <template #title>
              <img src="../icons/001-home.svg" class="icon" >
              <span class="span">Case</span>
            </template>
            <!-- case -->
            <el-menu-item-group>
                <el-menu-item index="postCase" >
                    <el-tooltip content="Case+" placement="right" effect="light">
                <span class="span-children">case+</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="myCase" >
                    <el-tooltip content="MyCase" placement="right" effect="light">
                <span class="span-children">myCase</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="handleCase" >
                    <el-tooltip content="handleCase" placement="right" effect="light">
                <span class="span-children">handleCase</span>
                    </el-tooltip>
                </el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- user -->
          <el-sub-menu index="2">
            <template #title>
              <img src="../icons/119-user-tie.svg" class="icon" >
                <span class="span">UserManagement</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="userManager" >
                <el-tooltip content="userManager" placement="right" effect="light">
                <span class="span-children">userManager</span>
                </el-tooltip>
              </el-menu-item>
              <el-menu-item index="userPremission" >
                <el-tooltip content="userPremission" placement="right" effect="light">
                <span class="span-children">userPremission</span>
                </el-tooltip>
              </el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- setting -->
          <el-sub-menu index="3">
            <template #title>
              <img src="../icons/149-cog.svg" class="icon" >
              <span class="span">Setting</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1" >
                <el-tooltip content="setting 1" placement="right" effect="light">
                <span class="span-children">setting 1</span>
                </el-tooltip>
              </el-menu-item>
              <el-menu-item index="3-2" >
                <el-tooltip content="setting 2" placement="right" effect="light">
                <span class="span-children">setting 2</span>
                </el-tooltip>
              </el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
        </el-menu>
        </div>
</template>

<script>
export default {
    name:'sideBar',
    data(){
        return{
            isRouter:true,
        }
    }

}
</script>

<style scoped>
#aa{
  display: flex;
}
</style>

