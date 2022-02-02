<template>
<div class="nav-wrapper">
  <nav class="navbar">
    Logo
    <div class="menu-toggle" :class="{'is-active': openMenu}" id="mobile-menu" @click="openMenu = !openMenu">
      <span class="bar"></span>
      <span class="bar"></span>
      <span class="bar"></span>
    </div>
    <ul class="nav" :class="{'mobile-nav': openMenu}">
      <li v-for="route in routes" :key="route.name" class="nav-item" @click="openMenu = !openMenu">
        <router-link :to="route.to">{{route.name}}</router-link>
      </li>
    </ul>
  </nav>
</div>
</template>

<script>
export default {
  name: 'Navbar',
  data: () => {
    return {
      openMenu: false
    }
  },
  props: {
    routes: {
      type: Array,
      required: true
    }
  }
}
</script>

<style>
.nav-wrapper {
  width: 100%;
  position: sticky;
  top: 0;
  background-color: #23ada4;
}

.navbar {
  display: grid;
  grid-template-columns: 1fr 3fr;
  align-items: center;
  height: 50px;
  overflow: hidden;
}

.navbar img {
  height: 16px;
  width: auto;
  justify-self: start;
  margin-left: 20px;
}

.navbar ul {
  list-style: none;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 10px;
  justify-self: end;
}

.nav-item a {
  color: white;
  font-size: 0.9rem;
  font-weight: 400;
  text-decoration: none;
  transition: color 0.3s ease-out;
}

.nav-item a:hover {
  color: rgb(196, 194, 194);
}
.menu-toggle .bar {
  width: 25px;
  height: 3px;
  background-color: #3f3f3f;
  margin: 5px auto;
  transition: all 0.3s ease-in-out;
}

.menu-toggle {
  justify-self: end;
  margin-right: 25px;
  display: none;
}

.menu-toggle:hover {
  cursor: pointer;
}

#mobile-menu.is-active .bar:nth-child(2) {
  opacity: 0;
}

#mobile-menu.is-active .bar:nth-child(1) {
  transform: translateY(8px) rotate(45deg);
}

#mobile-menu.is-active .bar:nth-child(3) {
  transform: translateY(-8px) rotate(-45deg);
}

@media only screen and (max-width: 720px) {
  .navbar ul {
    display: flex;
    flex-direction: column;
    position: fixed;
    justify-content: flex-start;
    top: 55px;
    background-color: #23ada4;
    width: 100%;
    height: calc(100vh - 55px);
    transform: translate(-101%);
    text-align: center;
    overflow: hidden;
  }
  .navbar li {
    padding: 15px;
  }
  .navbar li:first-child {
    margin-top: 50px;
  }
  .navbar li a {
    font-size: 1rem;
  }
  .menu-toggle,
  .bar {
    display: block;
    cursor: pointer;
  }
  .mobile-nav {
    transform: translate(0%) !important;
  }
}
</style>
