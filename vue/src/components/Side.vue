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
              <span class="span">{{ $t('case') }}</span>
            </template>
            <!-- case -->
            <el-menu-item-group>
              <el-menu-item index="mainView" >
                    <el-tooltip :content="$t('mainView')" placement="right" effect="light">
                <span class="span-children">{{ $t('mainView') }}</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="postCase" >
                    <el-tooltip :content="$t('postCase')" placement="right" effect="light">
                <span class="span-children">{{ $t('postCase') }}</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="myCase" >
                    <el-tooltip :content="$t('myCase')" placement="right" effect="light">
                <span class="span-children">{{ $t('myCase') }}</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="handleCase" >
                    <el-tooltip :content="$t('handleCase')" placement="right" effect="light">
                <span class="span-children">{{ $t('handleCase') }}</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="allCase" >
                    <el-tooltip :content="$t('allCase')" placement="right" effect="light">
                <span class="span-children">{{ $t('allCase') }}</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="reportCase" >
                    <el-tooltip :content="$t('reportCase')" placement="right" effect="light">
                <span class="span-children">{{ $t('reportCase') }}</span>
                    </el-tooltip>
                </el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- user -->
          <el-sub-menu index="2">
            <template #title>
              <img src="../icons/119-user-tie.svg" class="icon" >
                <span class="span">{{ $t('userManagement') }}</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="userManager" >
                <el-tooltip :content="$t('userManager')" placement="right" effect="light">
                <span class="span-children">{{ $t('userManager') }}</span>
                </el-tooltip>
              </el-menu-item>
              <el-menu-item index="userPremission" >
                <el-tooltip :content="$t('userPremission')" placement="right" effect="light">
                <span class="span-children">{{ $t('userPremission') }}</span>
                </el-tooltip>
              </el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- setting -->
          <el-sub-menu index="3">
            <template #title>
              <img src="../icons/149-cog.svg" class="icon" >
              <span class="span">{{ $t('setting') }}</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1" >
                <el-tooltip :content="$t('setting1')" placement="right" effect="light">
                <span class="span-children">{{ $t('setting1') }}</span>
                </el-tooltip>
              </el-menu-item>
              <el-menu-item index="3-2" >
                <el-tooltip :content="$t('setting2')" placement="right" effect="light">
                <span class="span-children">{{ $t('setting2') }}</span>
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

